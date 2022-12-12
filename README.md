# SensorAPI
REST API for manging weather sensors data

## How to use
### Register sensor

Send POST request to `/sensors/register` with body
```
{
  "name": "sensor-name"  
}
```
`name` is the name of the sensor.

### Create measurement
Send POST request to `/measurements` with body
```
{
  "value": 1,
  "raining": false,
  "sensor": [
    "name": "sensor-name"
  ]
}
```
where
* `value` is temperature (_float_)
* `raining` is raining value (_boolean_)
* `sensor` is sensor object from which measurement was made
* `name` is sensor's name

### Get all measurements

Send GET request to `/measurements`  
**Response:**
```
{
"measurements": [
  {
    "value": 1,
    "raining": true,
    "sensor": [
      "name": "sensor-name"
    ]
  },
  {
    "value": 2,
    "raining": false,
    "sensor": [
      "name": "sensor-name"
    ]
  },
  {
    "value": 3,
    "raining": true,
    "sensor": [
      "name": "sensor-name-2"
    ]
  }
]
}
```

### Get number of rainy days

Send GET request to `/measurements/rainyDaysCount`  
**Response:**
```
{
  "days": 10
}
```
`days` is the number of rainy days (_long_)
