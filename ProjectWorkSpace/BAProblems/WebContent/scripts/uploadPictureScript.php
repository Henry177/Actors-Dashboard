<?php

//Upload the picture
$fileDir = "../images/" . $_FILES["fileName"]["name"];

if (move_uploaded_file($_FILES["fileName"]["tmp_name"], $fileDir)) {
    echo "<p>Uploaded successfully!</p>";
} else {
    echo "<p>Could not uploaded picture!</p>";
}