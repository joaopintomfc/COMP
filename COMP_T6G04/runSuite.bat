@echo off
SET "suitedir=%CD%\testsuite\"
ECHO Working directory: "%suitedir%"
FOR /r %%f IN (.\testsuite\*) DO (
	IF NOT "%%~xf"==".txt" java -jar dsl.jar %%f
	echo.
	echo.
)
SET "tempdirf=%CD%\temp\*"
del /s /q %tempdirf% >NUL
SET "tempdir=%CD%\temp\"
rmdir /s /q %tempdir% >NUL
echo.
PAUSE&EXIT