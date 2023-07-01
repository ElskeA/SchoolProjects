<?php

require_once 'BudgetData.php';
$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST') {

    if(isset($_POST['UserID']))
    {
        $db = new BudgetData();
        if($db->resetCategory($_POST['UserID']))
        {
            $response['error'] = false;
            $response['message'] = "Reset data saved";
        }else{
            $response['error'] = true;
            $response['message'] = "Failed to save reset data";
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
