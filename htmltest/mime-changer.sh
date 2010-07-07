#!/bin/bash
FILES=$(find . -name "*.html" -or -name "*.css")
svn pset svn:mime-type text/html $FILES
