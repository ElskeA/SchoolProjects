<?php
require_once '../config.php';

class Login
{
    function userLogin()
    {
        $database = new config();
        $db = $database->connectDB();

        $statement = $db->prepare("SELECT UserID, Username, Password FROM UserTable");

        $statement->execute();
        if ($statement->rowCount() > 0) {
            if($statement->rowCount() > 0) {
                echo json_encode(array('Succes'=> true, 'data' => $statement->fetchAll(PDO::FETCH_ASSOC)));
            } else {
                echo json_encode(array('failed' => false, 'message' => 'Something went wrong.'));
            }
        }

    }
}