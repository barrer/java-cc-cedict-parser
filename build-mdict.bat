@echo off
java -Dfile.encoding=UTF-8 -jar cccedict.jar cedict_ts.u8 > build-mdict.log 2>&1
echo Done.
pause