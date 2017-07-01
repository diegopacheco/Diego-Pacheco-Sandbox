# habitat-example-plans
This repo contains the plans used in the Habitat tutorials. To build them:

* Clone this repo.
* Download the latest `hab` command-line interface tool for either [Mac OS X](https://api.bintray.com/content/habitat/stable/darwin/x86_64/hab-$latest-x86_64-darwin.zip?bt_package=hab-x86_64-darwin) or [Linux](https://api.bintray.com/content/habitat/stable/linux/x86_64/hab-$latest-x86_64-linux.tar.gz?bt_package=hab-x86_64-linux).
* If you don't have origin keys on your host machine, run `hab setup` to create your origin keys.
* Change directory to your local habitat-example-plans repo and run `hab studio enter`.
* From the root of the repo, run `build` with the name of plan you want to build.

This repo will be updated with changes to existing tutorials or when new tutorials are created.

## License

Copyright (c) 2016 Chef Software Inc. and/or applicable contributors

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
