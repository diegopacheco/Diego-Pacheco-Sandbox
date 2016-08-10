'use strict';
var yeoman = require('yeoman-generator');
var chalk = require('chalk');
var yosay = require('yosay');
var mkdirp = require('mkdirp');

module.exports = yeoman.Base.extend({
  prompting: function () {
    this.log(yosay(
      'Welcome to the fine ' + chalk.red('gradle') + ' generator!'
    ));

    var prompts = [{
      type: 'input',
      name: 'projectName',
      message: 'Enter the name of the gradle project',
    }];

    return this.prompt(prompts).then(function (props) {
      this.props = props;
    }.bind(this));
  },

  writing: function () {
    mkdirp.sync(this.props.projectName);
    mkdirp.sync(this.props.projectName + "/src/main/java");
    mkdirp.sync(this.props.projectName + "/src/main/resources");
    this.fs.copy(
      this.templatePath('build.gradle'),
      this.destinationPath(this.props.projectName + '/build.gradle')
    );
  },

});
