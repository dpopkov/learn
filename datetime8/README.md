Core Classes
------------

java.time       | Meaning           | Example
----------------|-------------------|----------
Instant         | instant of time   | timestamp
ZonedDateTime   | date-time with time zone information  | start of a conference call
LocalDate       | date without time zone information    | birthday
Duration        | time between two instants             | length of a conference call
Period          | amount of time in years, months, and days | length of a prison sentence


### Formatting and Parsing 

DateTimeFormatter  
- .parse(String)
- .format(TemporalAccessor)
- .ISO_DATE_TIME
- .ofLocalizedTime(FormatStyle.SHORT)
- .ofPattern("E")

### Interoperation

java.util classes:  
- Date.from(Instant)
- date.toInstant()
- Calendar.toInstant()
- timeZone.toZoneId()
- TimeZone.getTimeZone(zoneId)

java.sql classes:  
- Date <-> LocalDate
- TimeStamp <-> LocalDateTime
- TimeStamp <-> Instant

JPA - AttributeConverter
