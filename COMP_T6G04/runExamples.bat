@echo off
SET "examplesdir=%CD%\examples\"
ECHO Working directory: "%examplesdir%"
FOR /r %%f IN (.\examples\*) DO (
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