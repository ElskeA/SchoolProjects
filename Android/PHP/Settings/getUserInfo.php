<?php

require_once 'Settings.php';

$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST') {

    if (isset($_POST['UserID']))
    {
        $db = new Settings();
        if($db->getUserInfo($_POST['UserID'])){
            $response['error'] = false;
            $response['message'] = "Collected data";
        }else{
            $response['error'] = true;
            $response['message'] = "Failed to collect data";
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

