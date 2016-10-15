<?php

include_once 'connect.php';

if(isset($_POST['username']))
{
$data=$con->prepare("Select * from profile where username=?")
$data->execute([$_POST['username']]);

try{$row=$data->fetch(PDO::FETCH_BOTH);}
catch(PDOException $ex){}

$response=array();
foreach($row as $r)
{
$response['UID']=$r['UID'];
$response['username']=$r['username'];
$response['first']=$r['first'];
$response['last']=$r['last'];
$response['college']=$r['college'];
$response['email']=$r['email'];
$response['pic']=$r['pic'];
$response['credits']=$r['credits'];
$response['Qanswered']=$r['Qanswered'];
$response['datereg']=$r['datereg'];
$response['listQ']=$r['listQ'];
$response['rating']=$r['rating'];
}

echo json_encode($response);
?>