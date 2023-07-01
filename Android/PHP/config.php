<?php
    class config{
        private $conn = "";
        private $host = "adainforma.tk";
        private $user = "budgetapp";
        private $password = "+9Zf#youfd";
        private $database = "bp5_budgetapp";

        function __construct()
        {
            $conn = $this->connectDB();
            if(!empty($conn)){
                $this->conn = $conn;
            }
        }
        function connectDB(){
            $conn = new PDO("mysql:host=$this->host;dbname=$this->database", $this->user, $this->password);
            return $conn;
        }

    }
?>