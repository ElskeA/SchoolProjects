<?php

    require_once 'BudgetData.php';
    $response = array();

    if($_SERVER['REQUEST_METHOD'] =='POST') {

        if(isset($_POST['UserID']) and
            ($_POST['Groc']) and
            ($_POST['Hyg']) and
            ($_POST['Med']) and
            ($_POST['Pet']) and
            ($_POST['Other']) and
            ($_POST['Total']) and
            ($_POST['OverUnder']))
        {
            $db = new BudgetData();
            if($db->setReset($_POST['UserID'],
                            $_POST['Groc'],
                            $_POST['Hyg'],
                            $_POST['Med'],
                            $_POST['Pet'],
                            $_POST['Other'],
                            $_POST['Total'],
                            $_POST['OverUnder']))
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