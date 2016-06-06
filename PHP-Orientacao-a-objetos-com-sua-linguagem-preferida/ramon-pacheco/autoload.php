<?php

function customAutoload($className) {
    if (file_exists("class/".$className . '.php')) {
        require_once("class/".$className . '.php');
    }
}

spl_autoload_register('customAutoload');