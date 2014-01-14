
var UserMaintenance = function() {
	return {
		myVariable: null,

		init: function() {
			alert("UserMaintenance.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".UserMaintenance .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("UserMaintenance.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(UserMaintenance.init()); // Run after page loads