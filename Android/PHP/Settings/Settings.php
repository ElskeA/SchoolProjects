<?php

require_once '../config.php';

class Settings
{
    function getUserInfo($UserID)
    {
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("SELECT 	Username
                                            ,Password
                                            ,Email 
                                    FROM 	UserTable 
                                    WHERE 	UserID = :UserID");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            if($stmt->rowCount() > 0) {
                echo json_encode(array('success' => true, 'data' => $stmt->fetchAll(PDO::FETCH_OBJ)));
            } else {
                echo json_encode(array('failed' => false, 'message' => 'Failed to find data.'));
            }
        }return $stmt;
    }

    function updateUserInfo($UserID, $Username, $Password, $Email){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("UPDATE UserTable
                                    SET Username = :Username,
                                        Password = :Password,
                                        Email = :Email
                                    WHERE UserID = :UserID;");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->bindParam(":Username", $Username);
        $stmt->bindParam(":Password", $Password);
        $stmt->bindParam(":Email", $Email);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function getCategoryBudget($UserID)
    {
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("SELECT 		cat.Budget                               
                                                ,cat.Name
                                                ,cat.CategoryID
                                    FROM	Category cat
                                    JOIN	Budget				bud ON cat.BudgetID		= bud.BudgetID
                                    JOIN	UserTable			usr ON bud.UserID		= usr.UserID
                                    WHERE 	usr.UserID = :UserID
                                    GROUP 
                                    BY 		cat.CategoryID");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            if($stmt->rowCount() > 0) {
                echo json_encode(array('success' => true, 'data' => $stmt->fetchAll(PDO::FETCH_OBJ)));
            } else {
                echo json_encode(array('failed' => false, 'message' => 'Failed to find data.'));
            }
        }return $stmt;
    }

    function updateCategoryBudget($CategoryID, $Budget){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("UPDATE Category
                                    SET Budget = :Budget
                                    WHERE CategoryID = :CategoryID;");

        $stmt->bindParam(":CategoryID", $CategoryID);
        $stmt->bindParam(":Budget", $Budget);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function getTotalBudget($UserID)
    {
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("SELECT 	bud.Amount
                                            ,bud.BudgetID
                                    FROM	Budget bud
                                    JOIN	UserTable	usr ON bud.UserID = usr.UserID
                                    WHERE 	usr.UserID = :UserID
                                    GROUP 
                                    BY 		bud.Amount;");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            if($stmt->rowCount() > 0) {
                echo json_encode(array('success' => true, 'data' => $stmt->fetchAll(PDO::FETCH_OBJ)));
            } else {
                echo json_encode(array('failed' => false, 'message' => 'Failed to find data.'));
            }
        }return $stmt;
    }

    function updateTotalBudget($BudgetID, $Amount){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("UPDATE  Budget
                                    SET     Amount = :Amount
                                    WHERE   BudgetID = :BudgetID;");

        $stmt->bindParam(":BudgetID", $BudgetID);
        $stmt->bindParam(":Amount", $Amount);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

}