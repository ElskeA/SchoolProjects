<?php

require_once '../config.php';

class BudgetData
{
    function getData($UserID)
    {
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("SELECT 	*
                                    FROM 	ResetMonth 
                                    WHERE 	Month > MONTH(DATE_ADD(NOW(), INTERVAL -3 MONTH))
                                    AND		UserID = :UserID");

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

    function getCategory($UserID)
    {
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("SELECT 	usr.Username
            ,cat.CategoryID
            ,usr.UserID
			,SUM(trx.Amount) 	AS 	CategorySpend
			,cat.Name			AS	CategoryName
            ,cat.Budget			AS	CategoryBudget
            ,cat.Budget - sum(trx.Amount) AS CategoryLeft
            ,case				when cat.Budget - sum(trx.Amount) > 0 then 'Under'
                                else 'Over'
								end AS OverOrUnder
            FROM	CategoryTransaction trx
            JOIN	Category			cat ON trx.CategoryID	= cat.CategoryID
            JOIN	Budget				bud ON cat.BudgetID		= bud.BudgetID
            JOIN	UserTable			usr ON bud.UserID		= usr.UserID
            WHERE 	trx.IsActive = 1 	AND usr.UserID = :UserID
            GROUP 
            BY 		cat.Name
                    ,cat.Budget
                    ,usr.Username");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            if($stmt->rowCount() > 0) {
                echo json_encode(array('success' => true, 'data' => $stmt->fetchAll(PDO::FETCH_OBJ)));
            } else {
                echo json_encode(array('failed' => false, 'message' => 'Failed to get Category.'));
            }
        }return $stmt;
    }

    function addTransaction($CategoryID, $Amount){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("INSERT INTO CategoryTransaction(CategoryTransactionID, Date, Amount, IsActive, CategoryID)
                                    VALUES (NULL, curdate(), :Amount, 1, :CategoryID);");

        $stmt->bindParam(":CategoryID", $CategoryID);
        $stmt->bindParam(":Amount", $Amount);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function deleteTransaction($UserID){
        $database = new config();
        $db = $database->connectDB();

        $stmt= $db->prepare("DELETE FROM CategoryTransaction
                                    WHERE CategoryTransactionID IN (
			                        SELECT CategoryTransactionID
                                    FROM(
                                            SELECT 	trx.CategoryTransactionID
                                            FROM	CategoryTransaction trx
                                            JOIN	Category			cat ON trx.CategoryID	= cat.CategoryID
                                            JOIN	Budget				bud ON cat.BudgetID		= bud.BudgetID
                                            JOIN	UserTable			usr ON bud.UserID		= usr.UserID
                                            WHERE 	usr.UserID = :UserID
                                            ORDER
                                            BY 		trx.CategoryTransactionID DESC LIMIT 1
                                        )	a
			                        )");
        $stmt->bindParam(":UserID", $UserID);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function setReset($UserID, $Groc, $Hyg, $Med, $Pet, $Other, $Total, $OverUnder){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("INSERT INTO ResetMonth(ResetID, Month, UserID, Groceries, Hygiene, Medication, Pets, Other, Total, OverUnder)
                                    VALUES (NULL, MONTH(CURDATE()), :UserID, :Groc, :Hyg, :Med, :Pet, :Other, :Total, :OverUnder);");

        $stmt->bindParam(":UserID", $UserID);
        $stmt->bindParam(":Groc", $Groc);
        $stmt->bindParam(":Hyg", $Hyg);
        $stmt->bindParam(":Med", $Med);
        $stmt->bindParam(":Pet", $Pet);
        $stmt->bindParam(":Other", $Other);
        $stmt->bindParam(":Total", $Total);
        $stmt->bindParam(":OverUnder", $OverUnder);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function resetCategory($UserID){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("UPDATE CategoryTransaction
                                    SET IsActive = 0 
                                    WHERE IsActive IN (SELECT IsActive
                                    FROM(
                                        SELECT  IsActive
                                        FROM	CategoryTransaction trx
                                        JOIN	Category			cat ON trx.CategoryID	= cat.CategoryID
                                        JOIN	Budget				bud ON cat.BudgetID		= bud.BudgetID
                                        JOIN	UserTable			usr ON bud.UserID		= usr.UserID
                                        WHERE 	trx.IsActive = 1 	AND usr.UserID = :UserID
                                        )a
                                    );");

        $stmt->bindParam(":UserID", $UserID);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

    function addBudget($budget){
        $database = new config();
        $db = $database->connectDB();

        $stmt = $db->prepare("INSERT INTO Budget (BudgetID, Amount, UserID) 
                                    VALUES(NULL, :budget, LAST_INSERT_ID());");

        $stmt->bindParam(":budget", $budget);

        if ($stmt->execute()) {
            return true;
        } else {
            return false;
        }
    }

}