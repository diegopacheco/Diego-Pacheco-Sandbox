'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');

module.exports = class extends Generator {
  async prompting() {
    this.answers = await this.prompt([
      {
        type: "input",
        name: "names",
        message: "Gimme fuel, gimme fire , gimme the The list(\",\" separated) of fields you want generate, btiche!!!",
        default: "firstName"
      }
    ]);
  }

  writing() {
    this.log("Yo, Inputs to be generated: ", this.answers.names);
    
    this.fs.copyTpl(
      this.templatePath('app.component.html'),
      this.destinationPath('app.component.html'), 
      { value: this.answers.names }
    );
  }

  install(){}
};
