
<?php
//SIGNUP

/* USERNAME: 
   PASSWORD:
    
*/

include_once 'connect.php';

$response=array();

if(! ( (isset($_POST['u_name'])) && (isset($_post['pass_word'])) ) )
{
$response['Error']=1;
$response['ErCode']='Enter Username/Password';
}

else
{


$search=con->prepare("Select u_name from user where u_name=?");
$search->execute([$_POST['u_name']]);


$r=$search->fetch(PDO::FETCH_BOTH);
if($r['u_name']!=NULL)
	{$response['Error']=1;
	 $response['ErCode']='Username Already Exists';
	}
else
{ 
 try{
 	$newuser=con->prepare("insert into user(u_name,pass_word,uid) values(?,?,?)");
 	$newuser->execute([$_POST['u_name'],$_POST['pass_word'],CURRENT_TIMESTAMP]);
    }
 catch(PDOException $e){$response['Error']=1;$response['ErCode']='Unable to add new user';} 
}


}

echo json_encode($response);
?>