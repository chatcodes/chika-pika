<?php

include_once 'connect.php';

if((isset($_POST['username']))&&(isset($_POST['password])))
{
$validate=$con->prepare("SELECT Username,Password from login where Name=? AND Password=?");
$validate->execute([$_POST['username'],$_POST['password']);

try{$row=$validate->fetch(PDO::FETCH_BOTH);}
catch(PDOException $ex){}

$response=array();

if(($row['Name']==NULL)&&($row['Number']==NULL))
$response['svreply']="No Such Account Exists";

else
$response['svreply']="Welcome";
}

else
$response['svreply']="Enter Username/Password";

echo json_encode($response);

?>
