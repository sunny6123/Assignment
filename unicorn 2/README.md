# Unicorn Details API

Unicorn Details can be accessed and updated using below endpoints 


### Build the project

Compiles the project, runs the test and then creates an executable JAR file

```console
$ ./mvnw package
```

### Run the application

Run the application using Java and the executable JAR file produced by the Maven `package` task. The application will be
listening to port `8880`.

```console
$ java -jar target\unicorn-0.0.1-SNAPSHOT.jar
```

## API

### Store Readings

Endpoint

```text
POST /unicorns
```

Example of request body

```json
{
  "name": "Sparkle Princess",
  "hairColor": "White",
  "hornLength": 104,
  "hornColor": "Gold",
  "eyeColor":  "Sapphire",
  "height": 94,
  "heightUnit": "cm",
  "weight": 104,
  "weightUnit": "kg",
  "identifiableMarks": [
    {
      "side": "Left",
      "location": "Hind Quarters",
      "mark": "Star",
      "color": "Blue"
    }
  ]
}
```

Example of response

```json
{
  "unicornId”: 105
}
```

### Get Stored Readings

Endpoint

```text
GET /unicorns
```

Example response

```json
[
  {
    "unicornId": 1,
    "name": "Sparkle Princess",
    "hairColor": "White",
    "hornLength": 104,
    "hornColor": "Gold",
    "eyeColor":  "Sapphire",
    "height": 94,
    "heightUnit": "cm",
    "weight": 104,
    "weightUnit": "kg",
    "identifiableMarks": [
      {
        "side": "Left",
        "location": "Hind Quarters",
        "mark": "Star",
        "color": "Blue"
      }
    ]
  }
]

```

```text
GET /unicorns/<unicornId>
```

Example response

```json
{
  "unicornId": 1,
  "name": "Sparkle Princess",
  "hairColor": "White",
  "hornLength": 104,
  "hornColor": "Gold",
  "eyeColor":  "Sapphire",
  "height": 94,
  "heightUnit": "cm",
  "weight": 104,
  "weightUnit": "kg",
  "identifiableMarks": [
    {
      "side": "Left",
      "location": "Hind Quarters",
      "mark": "Star",
      "color": "Blue"
    }
  ]
}
```

### Update Stored Readings

Endpoint

```text
PUT /unicorns/<unicornId>
```

Example of request body

```json
{
  "unicornId": 1,
  "name": "Sparkle Princess",
  "hairColor": "White",
  "hornLength": 104,
  "hornColor": "Gold",
  "eyeColor":  "Sapphire",
  "height": 94,
  "heightUnit": "cm",
  "weight": 104,
  "weightUnit": "kg",
  "identifiableMarks": [
    {
      "side": "Left",
      "location": "Hind Quarters",
      "mark": "Star",
      "color": "Blue"
    }
  ]
}

```

Example response

```json
{
    "Unicorn details are updated for unicorn id": 1
}
```


### Additional details added

1. Added heightLengthUnit for unicorn details
2. Considered unit parameters as double to capture decimal values if any'
3. Considered name as Mandatory for unicorn as a validation
4. Considered H2 database for storing the data