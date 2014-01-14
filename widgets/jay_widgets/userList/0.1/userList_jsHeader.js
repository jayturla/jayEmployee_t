
var UserList = function() {
	return {
		myVariable: null,

		init: function() {
			alert("UserList.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".UserList .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("UserList.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(UserList.init()); // Run after page loads