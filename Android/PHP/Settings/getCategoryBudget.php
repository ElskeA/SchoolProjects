<?php

require_once 'Settings.php';

if($_SERVER['REQUEST_METHOD'] =='POST') {

    if (isset($_POST['UserID'])) {
        $db = new Settings();
        $db->getCategoryBudget($_POST['UserID']);
    }
}
