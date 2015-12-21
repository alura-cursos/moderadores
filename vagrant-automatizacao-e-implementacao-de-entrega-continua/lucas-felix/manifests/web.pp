exec { "apt-update":
  command => "/usr/bin/apt-get update"
}

package { ["openjdk-7-jre", "tomcat7", "mysql-server"]:
  ensure => installed,
  require => Exec["apt-update"]
}

service { "tomcat7":
  ensure => running,
  enable => true,
  hasstatus => true,
  hasrestart => true,
  require => Package["tomcat7"]
}

service { "mysql":
  ensure => running,
  enable => true,
  hasstatus => true,
  hasrestart => true,
  require => Package["mysql-server"]
}

exec { "musicjungle":
  command => "mysqladmin -uroot create musicjungle",
  unless => "mysql -uroot musicjungle",
  path => "/usr/bin",
  require => Service["mysql"]
}

file { "/var/lib/tomcat7/webapps/vraptor-musicjungle.war":
    source => "/vagrant/manifests/vraptor-musicjungle.war",
    owner => "tomcat7",
    group => "tomcat7",
    mode => 0644,
    require => Package["tomcat7"],
    notify => Service["tomcat7"]
}

file_line { "production":
  file => "/etc/default/tomcat7",
  line => "JAVA_OPTS=\"\$JAVA_OPTS -Dbr.com.caelum.vraptor.environment=production\"",
  require => Package["tomcat7"],
  notify => Service["tomcat7"]
}

define file_line($file, $line) {
  exec { "/bin/echo '${line}' >> '${file}'":
    unless => "/bin/grep -qFx '${line}' '${file}'"
  }
}
