<?php

require_once 'Registering.php';
$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST'){

    if(isset($_POST['username']) and
        isset($_POST['password']) and
        isset($_POST['email']))
        {
            $db = new Registering();
            if($db->signUp($_POST['username'],
                        $_POST['password'],
                        $_POST['email'])){
                $response['error'] = false;
                $response['message'] = "User registered succesfully";
            }else{
                $response['error'] = true;
                $response['message'] = "Registry failed";
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
