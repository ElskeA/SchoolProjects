<?php
require_once '../config.php';

class Registering
{

    function signUp($username, $password, $email)
    {
        $database = new config();
        $db = $database->connectDB();

        $statement = $db->prepare("INSERT INTO UserTable (UserID, Username, Password, Email)
                                        VALUES(NULL, :username, :password, :email);");

        $statement->bindParam(":username", $username);
        $statement->bindParam(":password", $password);
        $statement->bindParam(":email", $email);

        if ($statement->execute()) {
            return true;
        } else {
            return false;
        }

    }
}


