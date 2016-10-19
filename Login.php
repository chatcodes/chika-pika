<?php

include_once 'connect.php';
$response=array();
if((isset($_POST['username']))&&(isset($_POST['password])))
{
$validate=$con->prepare("SELECT u_name,Pass_word from user where u_Name=? AND Pass_word=?");
$validate->execute([$_POST['u_name'],$_POST['pass_word']);

try{$row=$validate->fetch(PDO::FETCH_BOTH);}
catch(PDOException $ex){$response['Error']=1;$response['ErCode']='Unable to Access Data';}

if(($row['u_name']==NULL)&&($row['pass_word']==NULL))
{
$response['Error']=1;$response['ErCode']='Wrong Username/Password';}
}

else
{
$response['Error']=0;
$response['svreply']='Enter';
}

echo json_encode($response);

?>
