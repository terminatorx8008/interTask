document.getElementById('home-tab0').addEventListener('click', function (event) {
    event.preventDefault();
    var tab = new mdb.Tab(document.getElementById('home-tab0'));
    tab.show();
});

document.getElementById('profile-tab0').addEventListener('click', function (event) {
    event.preventDefault();
    var tab = new mdb.Tab(document.getElementById('profile-tab0'));
    tab.show();
});

document.getElementById('contact-tab0').addEventListener('click', function (event) {
    event.preventDefault();
    var tab = new mdb.Tab(document.getElementById('contact-tab0'));
    tab.show();
});

