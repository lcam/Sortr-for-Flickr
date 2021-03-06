# Sortr for Flickr ver 0.1.4

Sortr for Flickr searches for Flickr posts

Developed by: Leon Cam

## Features

* [x] Run a Flickr public feed search based on a tag
* [x] Search results are sorted by upload date, descending order
* [x] Swipe down on list of search results to refresh the search
* [x] Click on a thumbnail image to view its larger version by itself on a new page

## Libraries and Patterns Used

1. [Retrofit](http://github.com/square/retrofit) - REST web services
2. [Google GSON](https://github.com/google/gson) - Serialization/Deserialization of service responses
3. [Picasso](http://square.github.io/picasso/) - Image downloading and caching library for Android
4. [Butterknife](http://jakewharton.github.io/butterknife/) - Bind Android views and callbacks to fields and methods
5. [Dagger](https://github.com/google/dagger) - Dependency injector for Android and Java
6. Flickr API
7. MVP (Model-View-Presenter) Pattern

## Changelog

ver 0.1
* [x] Original release

ver 0.1.1
* [x] Fixed keyboard not hiding after submitting a tag

ver 0.1.2
* [x] Users can now swipe down on list of search results to refresh
* [x] Fixed keyboard not hiding when app starts up

ver 0.1.3
* [x] Display image title on full image page instead of image author
* [x] Integrated Butterknife into project to reduce boilerplate code

ver 0.1.4
* [x] Incorporated Dagger into project

## Screenshots

<img src='https://i.imgur.com/E6vQNSF.png' title='Screenshots' width='300px' alt='Screenshots' /> <img src='https://i.imgur.com/zskJ56h.png' title='Screenshots' width='300px' alt='Screenshots' />


## License

    Copyright 2016 Leon Cam

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
