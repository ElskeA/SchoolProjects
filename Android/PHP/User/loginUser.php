<?php

require_once 'Login.php';

if($_SERVER['REQUEST_METHOD'] =='GET') {
        $db = new Login();
        $db->userLogin();
}

