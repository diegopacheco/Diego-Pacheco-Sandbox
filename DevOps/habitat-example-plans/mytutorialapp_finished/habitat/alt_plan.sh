# To use this alternative version of the mytutorialapp plan, simply rename the 
# existing plan.sh in this directory and rename this file to plan.sh. You can then run 
# the build command against this version of the plan, which will download the source tarball
# instead of referencing it locally.

pkg_origin=myorigin
pkg_name=mytutorialapp
pkg_version=0.2.0
pkg_maintainer="Your Name <your email address>"
pkg_license=()
pkg_source=https://s3-us-west-2.amazonaws.com/${pkg_name}/${pkg_name}-${pkg_version}.tar.gz
pkg_shasum=e4e988d9216775a4efa4f4304595d7ff31bdc0276d5b7198ad6166e13630aaa9
pkg_filename=${pkg_name}-${pkg_version}.tar.gz
pkg_deps=(core/node)
pkg_exports=( [port]=listening_port )
pkg_exposes=(port)


do_build() {
  # The mytutorialapp source code is unpacked into a directory,
  # mytutorialapp-0.2.0, at the root of $HAB_CACHE_SRC_PATH. If you were downloading
  # an archive that didn't match your package name and version, you would have to
  # copy the files into $HAB_CACHE_SRC_PATH.

  # This installs both npm as well as the nconf module we listed as a
  # dependency in package.json.
  npm install
}

do_install() {
  # Our source files were copied over to the HAB_CACHE_SRC_PATH in do_build(),
  # so now they need to be copied into the root directory of our package through
  # the pkg_prefix variable. This is so that we have the source files available
  # in the package.
  cp package.json ${pkg_prefix}
  cp server.js ${pkg_prefix}

  # Copy over the nconf module to the package that we installed in do_build().
  mkdir -p ${pkg_prefix}/node_modules/
  cp -vr node_modules/* ${pkg_prefix}/node_modules/
}
