#!/bin/sh
set -e -x

if which puppet > /dev/null ; then
	echo "Puppet is already installed"
	exit 0
fi

export DEBIAN_FRONTEND=noninteractive
wget -qO /tmp/puppetlabs-release-precise.deb https://apt.puppetlabs.com/puppetlabs-release-precise.deb

dpkg -i /tmp/puppetlabs-release-precise.deb
rm /tmp/puppetlabs-release-precise.deb
aptitude update
echo Installing puppet
aptitude install -y puppet
echo "Puppet installed!"
