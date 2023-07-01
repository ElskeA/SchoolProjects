<?php

require_once 'BudgetData.php';

if($_SERVER['REQUEST_METHOD'] =='POST'){

    if(isset($_POST['UserID'])){

        $db = new BudgetData();
        $db->getData($_POST['UserID']);

}
}
