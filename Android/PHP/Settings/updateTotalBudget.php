<?php

require_once 'Settings.php';

$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST'){

    if(isset($_POST['BudgetID']) and
        isset($_POST['Amount']))
    {
        $db = new Settings();
        if($db->updateTotalBudget($_POST['BudgetID'],
            $_POST['Amount'])){
            $response['error'] = false;
            $response['message'] = "Updated total  budget";
        }else{
            $response['error'] = true;
            $response['message'] = "Failed to update budget";
        }
    }else{
        $response['error'] = true;
        $response['message'] = "Required fields are missing";
    }

}else{
    $response['error'] = true;
    $response['message'] = "Invalid request";
}


echo json_encode($response);
