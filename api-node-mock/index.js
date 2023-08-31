const express = require('express');
const app = express();
const addressesData = require('./addresses.json');
const phonesData = require('./phones.json');
const documentsData = require('./documents.json');
const peopleData = require('./person.json');

function filterData(data, ids) {
  if (ids) {
    return data.filter(item => ids.includes(item.personId));
  } else {
    return data;
  }
}

app.get('/person', (req, res) => {
    const ids = req.query.ids?.split(',');
  res.json(peopleData.filter(item => ids.includes(item.id)));
});

app.get('/addresses', (req, res) => {
    const ids = req.query.ids?.split(',');
  res.json(filterData(addressesData.addresses, ids));
});

app.get('/phones', (req, res) => {
    // setTimeout(() => { 
        const ids = req.query.ids?.split(',');
        res.json(filterData(phonesData.phones, ids));   
        
    // }, 5000); 
  
});

app.get('/documents', (req, res) => {
    // setTimeout(() => { 
    const ids = req.query.ids?.split(',');
  res.json(filterData(documentsData.documents, ids));
// }, 5000); 
});

const port = 3000; 
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
