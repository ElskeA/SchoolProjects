<?php

require_once 'Settings.php';

$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST'){

    if(isset($_POST['CategoryID']) and
        isset($_POST['Budget']))
    {
        $db = new Settings();
        if($db->updateCategoryBudget($_POST['CategoryID'],
            $_POST['Budget'])){
            $response['error'] = false;
            $response['message'] = "Updated category budget";
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
