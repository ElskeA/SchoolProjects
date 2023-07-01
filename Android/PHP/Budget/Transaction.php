<?php

require_once 'BudgetData.php';
$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST') {

    if(isset($_POST['CategoryID']) and
        isset($_POST['Amount'])) {
        $db = new BudgetData();
        if($db->addTransaction($_POST['CategoryID'],
                                $_POST['Amount'])){
                $response['error'] = false;
                $response['message'] = "Transaction added";
            }else{
                $response['error'] = true;
                $response['message'] = "Transaction failed";
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




