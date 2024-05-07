document.getElementById('tab-login').addEventListener('click', function (event) {
    event.preventDefault();
    var tab = new mdb.Tab(document.getElementById('tab-login'));
    tab.show();
});
document.getElementById('tab-register').addEventListener('click', function (event) {
    event.preventDefault();
    var tab = new mdb.Tab(document.getElementById('tab-register'));
    tab.show();
});
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('registerRepeatPassword').addEventListener('keyup', function (event) {
        var password = document.getElementById('registerPassword').value;
        var repeatPassword = document.getElementById('registerRepeatPassword').value;
        if (password !== repeatPassword) {
            document.getElementById('registerCheckText').innerText = 'Passwords do not match';
        } else {
            document.getElementById('registerCheckText').innerText = '';
            document.getElementById('submit-btn').disabled = false;
        }
    });
    document.getElementById('registerPassword').addEventListener('input', function (event) {
        const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        var password = document.getElementById('registerPassword').value;
        if (!pattern.test(password)) {
            document.getElementById('passwordCheck').innerText = 'Password must contain at least 8 characters, including uppercase, lowercase, number and special character';
        } else {
            document.getElementById('passwordCheck').innerText = '';
        }
    });
});
