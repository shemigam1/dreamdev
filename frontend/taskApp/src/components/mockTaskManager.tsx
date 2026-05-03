import React from "react";

function mockTaskManager() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        tasks: [
          "learn javascript",
          "practice DOM manipulation",
          "build a mini project",
          "revise CSS Flexbox",
        ],
      });
    });
  });
}

export default mockTaskManager;
