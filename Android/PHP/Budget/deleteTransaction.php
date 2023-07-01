<?php

require_once 'BudgetData.php';
$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if (isset($_POST['UserID'])) {
        $db = new BudgetData();
        if ($db->deleteTransaction($_POST['UserID'])) {
            $response['error'] = false;
            $response['message'] = "Transaction deleted";
        } else {
            $response['error'] = true;
            $response['message'] = "Failed to delete";
        }
    } else {
        $response['error'] = true;
        $response['message'] = "Required fields are missing";
    }

} else {
    $response['error'] = true;
    $response['message'] = "Invalid request";
}

echo json_encode($response);
