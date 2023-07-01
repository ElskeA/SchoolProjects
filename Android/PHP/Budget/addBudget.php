<?php

require_once 'BudgetData.php';
$response = array();

if($_SERVER['REQUEST_METHOD'] =='POST') {

    if(isset($_POST['budget'])) {
        $db = new BudgetData();
        if($db->addBudget($_POST['budget'])){
            $response['error'] = false;
            $response['message'] = "Budget added";
        }else{
            $response['error'] = true;
            $response['message'] = "Couldn't add budget";
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