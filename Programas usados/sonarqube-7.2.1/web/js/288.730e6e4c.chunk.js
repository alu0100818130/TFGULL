(window.webpackJsonp=window.webpackJsonp||[]).push([[288],{1610:function(n,t,o){"use strict";o.r(t),o.d(t,"OrganizationAdmin",function(){return p});var i,r=o(0),e=o(15),a=o(13),c=o(969),s=(i=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(n,t){n.__proto__=t}||function(n,t){for(var o in t)t.hasOwnProperty(o)&&(n[o]=t[o])},function(n,t){function o(){this.constructor=n}i(n,t),n.prototype=null===t?Object.create(t):(o.prototype=t.prototype,new o)}),p=function(n){function t(){var t=null!==n&&n.apply(this,arguments)||this;return t.isOrganizationAdmin=function(){return t.props.organization&&t.props.organization.canAdmin},t.checkPermissions=function(){t.isOrganizationAdmin()||Object(c.a)()},t}return s(t,n),t.prototype.componentDidMount=function(){this.checkPermissions()},t.prototype.componentDidUpdate=function(){this.checkPermissions()},t.prototype.render=function(){return this.isOrganizationAdmin()?r.cloneElement(this.props.children,{location:this.props.location,organization:this.props.organization}):null},t}(r.PureComponent);t.default=Object(e.connect)(function(n,t){return{organization:Object(a.getOrganizationByKey)(n,t.params.organizationKey)}})(p)},969:function(n,t,o){"use strict";var i=o(75),r=o(139),e=o(136);t.a=function(){var n=Object(i.default)(),t=Object(r.a)(),o=window.location.pathname+window.location.search+window.location.hash;n.dispatch(Object(e.c)()),t.replace({pathname:"/sessions/new",query:{return_to:o}})}}}]);
//# sourceMappingURL=288.730e6e4c.chunk.js.map