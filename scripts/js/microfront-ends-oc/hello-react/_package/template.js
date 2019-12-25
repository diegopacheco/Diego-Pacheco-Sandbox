var oc=oc||{};oc.components=oc.components||{};oc.components['6139dee36578b2dd28182b43e77acae09619a301']=function(model){
  var modelHTML =  model.__html ? model.__html : '';
  var staticPath = model.reactComponent.props._staticPath;
  var props = JSON.stringify(model.reactComponent.props);
  var randomId = Math.random() * 10000000;
  var reactRootId = "oc-reactRoot-hello-react-" + randomId;
  return '<div id="'+ reactRootId +'" class="oc-reactRoot-hello-react">' + modelHTML + '</div>' +
    '<style>.oc__hello-react-styles-css__special__1c8PSR6T{background:#db7093;color:#fff}</style>' +
    '<script>' +
    'window.oc = window.oc || {};' +
    'oc.cmd = oc.cmd || [];' +
    'oc.cmd.push(function(oc){' +
    'oc.events.fire(\'oc:cssDidMount\', \'.oc__hello-react-styles-css__special__1c8PSR6T{background:#db7093;color:#fff}\');' +
      'oc.requireSeries([{"global":["Object","assign"],"url":"https://unpkg.com/es6-object-assign@1.1.0/dist/object-assign-auto.min.js","name":"Object.assign"},{"global":"PropTypes","url":"https://unpkg.com/prop-types@15.7.2/prop-types.min.js","name":"prop-types"},{"global":"React","url":"https://unpkg.com/react@16.9.0/umd/react.production.min.js","name":"react"},{"global":"ReactDOM","url":"https://unpkg.com/react-dom@16.9.0/umd/react-dom.production.min.js","name":"react-dom"}], function(){' +
        'oc.require(' +
          '["oc", "reactComponents", "a51f2424b74a37597e011fc0b96b7d983f7d3f91"],' + 
          '"' + staticPath + 'react-component.js",' +
          'function(ReactComponent){' +
            'var targetNode = document.getElementById("'+ reactRootId +'");' +
            'targetNode.setAttribute("id","");' +
            'ReactDOM.hydrate(React.createElement(ReactComponent,' +  props + '),targetNode);' +
          '}' +
        ');' +
      '});' +
    '});' +
  '</script>'
}