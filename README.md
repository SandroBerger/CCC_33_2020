# Coding Contest 33 (April 2020)
The input files for all levels can be found under the resouce folder where also the output files get saved to.

## Level 1

Find the minimum and the maximum for each type of value, except for
the altitude where we already know the minimum is 0 (generally, but
the slice of data you see might not have it).
Float values are compared with a maximum allowed error of 10-5

<br>

|         | Input           | Output  |
| ------------- |-------------| -----|
| Format      | N <br>timestamp,lat,long,altitude <br>(repeats N times) | minTimestamp maxTimestamp <br>minLat maxLat <br> minLong maxLong <br>maxAltitude |
| Types      | N (int) Number of flight entries that follow <br>timestamp (int) Amount of seconds since a fixed point in time <br>lat (float) North latitude of the coordinate. In degrees <br>long (float) East longitude of the coordinate. In degrees <br>altitude (float) Meters above the sea level      |   minTimestamp (int)<br>maxTimestamp (int)<br>minLat (float)<br>maxLat (float)<br>minLong (float)<br>maxLong (float)<br>maxAltitude (float) |
| Example | 5<br>136932,48.297,16.503,1379<br>144068,45.262,39.702,1866<br>212782,41.287,2.089,0<br>370277,43.959,21.427,11582<br>578963,51.531,19.923,10058      |    136932 578963<br>41.287 51.531<br>2.089 39.702<br>11582 |

## Level 2
Repeated for each pair of airports, A and B, that have at least one flight
going from A to B. Direction matters
Sort alphabetically by A and then B

* Each entry from the previous level will receive 3 new fields.
* For each entry you now know where the plane is coming from, where it’s
going and when it took off.
* The starting and destination airports are given as strings, denoting their IATA
codes.
* The takeoff time is given as a timestamp.
* Based on this data, for each pair of airports, A and B, count the number of
unique flights that start from A and go to B.
* Output all pairs that have at least one flight, and the number of flights between
them
* Sort them alphabetically by A and then B.

<br>

|         | Input           | Output  |
| ------------- |-------------| -----|
| Format      | N<br>timestamp,lat,long,altitude,start,destination,takeoff<br>(repeats N times) | A B flightCount |
| Types      | N (int) Number of flight entries that follow <br>timestamp (int) Amount of seconds since a fixed point in time <br>lat (float) North latitude of the coordinate. In degrees <br>long (float) East longitude of the coordinate. In degrees <br>altitude (float) Meters above the sea level <br>start (string) IATA code of the start airport<br>destination (string) IATA code of the destination airport<br>takeoff (int) Timestamp at which the flight took off      |   A (string) IATA code of the start airport<br>B (string) IATA code of the destination airport<br>flightCount (int) Number of flights that start in A and go to B |
| Example | 10<br>34103,51.331,-0.393,3962.0,LPPT,EGLL,26949<br>107649,38.024,-2.556,10972.0,LEMG,ESSA,106411<br>113591,49.003,17.515,10363.0,LLBG,EDDB,102016<br>223214,53.469,25.524,9448.0,LSGG,UUEE,215051<br>294080,54.146,8.657,11574.0,EKCH,EGKK,292283<br>375909,48.051,0.808,11887.0,EGGW,LEBL,373584<br>636037,53.141,-0.391,10058.0,EIDW,LZIB,634073<br>649847,53.564,9.846,1828.0,EDDH,EGLL,649106<br>652143,46.948,-1.463,10675.0,EBBR,LPPT,648044<br>659210,52.59,6.392,10363.0,EKCH,EBBR,655729     |    EBBR LPPT 1<br>EDDH EGLL 1<br>EGGW LEBL 1<br>EIDW LZIB 1<br>EKCH EBBR 1<br>EKCH EGKK 1<br>LEMG ESSA 1<br>LLBG EDDB 1<br>LPPT EGLL 1<br>LSGG UUEE 1 |
