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
    
    var nameArray = this.answers.names.split(',');

    var baseCode = '<label>__NAME:\n' + 
    '<input type="text" name="input" ng-model="example.text"\n' +
           'ng-pattern="example.word" required ng-trim="false">\n' +
    '</label>\n'+
    '<BR/>\n'

    var code = "" 

    for(var i=0;i<nameArray.length;i++){
      code += baseCode.replace("__NAME", nameArray[i])
    }

    this.fs.copyTpl(
      this.templatePath('app.component.html'),
      this.destinationPath('app.component.html'), 
      { code: code }
    );
  }

  install(){}
};
