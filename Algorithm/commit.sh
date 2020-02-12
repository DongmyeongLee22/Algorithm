#!/usr/bin/env bash

message=$1

echo ">>>>>>>> git add all <<<<<<<<"
git add -A;

echo ">>>>>>>> git commit message: ${message} <<<<<<<<<"
git commit -m "$message";

echo ">>>>>>>> git push origin master <<<<<<<<<<"
git push origin master

