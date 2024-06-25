@echo off
setlocal

REM Define the output file
set outputFile=search_results.txt

REM Clear the output file if it exists
if exist %outputFile% del %outputFile%

REM Define the search terms
set searchTerms=loading progress encrypt decrypt auth security

REM Loop through the search terms and run findstr for each
for %%t in (%searchTerms%) do (
    echo Searching for %%t... >> %outputFile%
    echo ----------------------------------- >> %outputFile%
    findstr /s /i /c:"%%t" *.* >> %outputFile%
    echo. >> %outputFile%
)

echo All searches are complete. Results saved in %outputFile%.

endlocal
