load from "/database/config/db2inst1/arcos-ny-statewide-itemized.csv" 
of del modified by DATEFORMAT="MMDDYYYY"  MESSAGES load.msg INSERT INTO CSE532.DEA_NY NONRECOVERABLE;