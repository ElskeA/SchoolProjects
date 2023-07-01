<?php

require_once 'Settings.php';

$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST'){

    if(isset($_POST['UserID']) and
        isset($_POST['Username']) and
        isset($_POST['Password']) and
        isset($_POST['Email']))
    {
        $db = new Settings();
        if($db->updateUserInfo($_POST['UserID'],
            $_POST['Username'],
            $_POST['Password'],
            $_POST['Email'])){
            $response['error'] = false;
            $response['message'] = "Updated personal info";
        }else{
            $response['error'] = true;
            $response['message'] = "Failed to update persona info";
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
