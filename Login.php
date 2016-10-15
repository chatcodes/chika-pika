<?php

include_once 'connect.php';

if((isset($_POST['username']))&&(isset($_POST['password])))
{
$validate=$con->prepare("SELECT Username,Password from login where Name=? AND Password=?");
$validate->execute([$_POST['username'],$_POST['password']);

try{$row=$validate->fetch(PDO::FETCH_BOTH);}
catch(PDOException $ex){}

if(($row['Name']==NULL)&&($row['Number']==NULL))
$response="No Such Account Exists";

else
$response="Welcome";
}

else
$response="Enter Username/Password";

echo json_encode($response);

?>