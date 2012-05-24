cls

SET base_arch=D:\diego\svn-repos\wcsiLegra\cortellis-architecture\Architecture-SRC\
SET parent=%base_arch%ngm-core-parent

pushd %parent%
mvn clean install -T 4C

