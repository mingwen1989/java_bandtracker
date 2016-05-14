# Band Tracker

#### Epicodus Week Four Code Review, 05/13/2016
#### Ming Wen

## Description

A simple band tracking web application that allows the user to track bands and the venues where they've played concerts.

## Technologies Used

jUnit ver 4.+ Fluentlenium ver 0.13.0 Velocity ver 1.7 Java HTML5 CSS3 Bootstrap ver 3.3

## Setup

Clone this repository:
```
$ cd ~/Desktop
$ git clone https://github.com/themingfu/java_bandtracker
$ cd java_bandtracker
```

Open terminal and run Postgres:
```
$ postgres
```

Open a new tab in terminal by pressing ⌘t and create `bandtracker` database:
```
$ psql
$ CREATE DATABASE bandtracker;
\c bandtracker;
$ CREATE TABLE bands (id serial PRIMARY KEY, name varchar);
$ CREATE TABLE venues (id serial PRIMARY KEY, name varchar);
$ CREATE DATABASE bandtracker_test WITH TEMPLATE bandtracker;
```

Navigate to the terminal and restore the database
```
$ psql bandtracker < bandtracker.sql
```

Navigate back to the directory where this repository has been cloned and run gradle:
```
$ gradle run
```

### License

Available for use under the MIT license.

{This is boilerplate legal language. Read through it, and if you like it, use it. There are other license agreements online, but you can generally copy and paste this.}

Copyright (c) 2016 **Ming Wen**

  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
